/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

"use strict";
var registerApi = '/api/sign-up';
var studentLogInApi = ({email}) = '/api/login/${email}';
var studentApi = ({studentID}) => `//localhost:8080/api/student/${studentID}`;
var supervisorApi = ({supervisorID}) => `//localhost:8080/api/supervisor/${supervisorID}`;

const app = Vue.createApp({

    data() {
        return {
            user: new Object(),
            supervisor: new Object(),
            student: new Object(),
            signInMessage: "Please sign in to continue."

        };
    },

    mounted() {
        //alert('Mounted method called');
    },

    methods: {

        registerUser() {
// send POST request to service to create customer
            axios.post(registerApi, this.user)
                    .then(() => {
                        window.location = 'index.html';

                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        logInStudent() {
            axios.get(studentLogInApi({'email': this.user.email}))
                    .then(response => {
                        if(this.user.password == response.data.password){
                            this.user = repsonse.data;
                    dataStore.commit("signIn", this.user);
                    window.location = "studentprofile.html"
                        }else{
                            this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                        }
            })
                    .catch(error => {
                        this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
            });
        },
    

        registerSupervisor() {
            // send POST request to service to create supervisor
            axios.post(registerApi, this.supervisor).then(() => {
                window.location = 'index.html';
            })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },

        registerStudent() {
            // send POST request to service to create student
            axios.post(registerApi, this.student).then(() => {
                window.location = 'index.html';
            })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },

        supervisorSignIn() {
            alert("Sign In " + this.supervisor.emailAddress + ", " + this.supervisor.password);
            axios.get(supervisorApi({'Email Address': this.supervisor.emailAddress})).then(response => {
                this.supervisor = response.data;
                dataStore.commit("signIn", this.supervisor);
                window.location = 'index.html';
            })
                    .catch(error => {
                        console.error(error);
                        this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                    });
        }

    }
});

// mount the page - this needs to be the last line in the file
import { dataStore } from './data-store.js'
        app.use(dataStore);
app.mount("#content");
