/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global axios, Vue */

"use strict";
var registerApi = `//localhost:8090/api/sign-up`;
var logInApi = ({email}) => `//localhost:8090/api/login/${email}`;


const app = Vue.createApp({

    data() {
        return {
            user: new Object(),
            signInMessage: "Please sign in to continue."

        };
    },

    mounted() {
        //alert('Mounted method called');
    },

    methods: {

        registerStudentUser() {
// send POST request to service to create user
            dataStore.commit("signIn", this.user);
            axios.post(registerApi, this.user)
                    .then(() => {
                        window.location = 'studentsignup.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        registerSupervisorUser(){
            dataStore.commit("signIn", this.user);
            axios.post(registerApi, this.user)
                    .then(() =>{
                        window.location = 'supervisorsignup.html';
                
            })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
            });
        },
        
        supervisorSignIn() {

            axios.get(logInApi({'email': this.user.email}))
                    .then(response => {
                        if (this.user.password === response.data.password) {
                            this.user = response.data;
                            dataStore.commit("signIn", this.user);
                            window.location = 'index.html';
                            
                        } else {
                            this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                        }
                    })
                    .catch(error => {
                        this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                    });
        },

        studentSignIn() {

            axios.get(logInApi({'email': this.user.email}))
                    .then(response => {
                        if (this.user.password === response.data.password) {
                            this.user = response.data;
                            dataStore.commit("SignIn", this.user);
                            window.location = 'index.html';
                            
                        } else {
                            this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                        }
                    })
                    .catch(error => {
                        this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                    });
        }
    }
});
// mount the page - this needs to be the last line in the file
import { dataStore } from './data-store.js'
        app.use(dataStore);

// import navigation  menu component
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);

app.mount("#content");
