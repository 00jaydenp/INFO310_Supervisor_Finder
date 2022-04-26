/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

"use strict";
var registerApi = `//localhost:8090/api/sign-up`;
var logInApi = ({email}) => `//localhost:8090/api/login/${email}`;
var studentSignUpApi = `//localhost:8090/api/sign-up/student`;


const app = Vue.createApp({

    data() {
        return {
            user: new Object(),
            //supervisor: new Object(),
            student: new Object(),
            signInMessage: "Please sign in to continue."

        };
    },

    mounted() {
        //alert('Mounted method called');
    },

    methods: {

        registerUser() {
// send POST request to service to create user
            axios.post(registerApi, this.user)
                    .then(() => {
                        window.location = 'studentlogin.html';

                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },

        logIn() {

            axios.get(logInApi({'email': this.user.email}))
                    .then(response => {
                        if (this.user.password === response.data.password) {
                            this.user = response.data;
                            dataStore.commit("logIn", this.user);
                            window.location = 'studentprofilesetup.html';
                            
                        } else {
                            this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                        }
                    })
                    .catch(error => {
                        this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                    });
        },
        
        /*studentProfileSetUp() {
// send POST request to service to create user
            axios.post(studentSignUpApi, this.student)
                    .then(() => {
                        window.location = 'index.html';

                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        }*/
        
        studentProfileSetUp() {
            axios.post(studentSignUpApi, this.student)
                    .then(() => {
                        //console.log("Save!")
                        //this.student = response.data;
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        console.log(this.student);
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        }

    }
});

// mount the page - this needs to be the last line in the file
import { dataStore } from './data-store.js'
        app.use(dataStore);
app.mount("#content");
