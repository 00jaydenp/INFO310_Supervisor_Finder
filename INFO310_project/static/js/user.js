/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global axios, Vue, Vuex, vm */

"use strict";
var registerApi = `//localhost:8090/api/sign-up`;
var logInApi = ({email}) => `//localhost:8090/api/login/${email}`;
var studentsApi = '//localhost:8090/api/sign-up/student';
var studentEmailApi = ({email}) => `//localhost:8090/api/student/${email}`;
var supervisorApi = '//localhost:8090/api/sign-up/supervisor';
var supervisorEmailApi = ({email}) => `//localhost:8090/api/supervisor/${email}`;

const app = Vue.createApp({

    data() {
        return {
            newUser: new Object(),
            student: new Object({
                user: new Object()
            }),
            supervisor: new Object({
                user: new Object()
            }),
            signInMessage: "Please sign in to continue."

        };
    },
    
    computed: Vuex.mapState({
        user: 'user',
        studentuser: 'studentuser',
        supervisoruser: 'supervisoruser'
    }),

    mounted() {
        //alert('Mounted method called');
    },

    methods: {
        loginStudent(userEmail){
            axios.get(studentEmailApi({'email': userEmail}))
                    .then(response => {
                        this.student = response.data;
                        dataStore.commit("signInStudent", this.student);
            });
        },
        
        loginSupervisor(userEmail){
            axios.get(supervisorEmailApi({'email': userEmail}))
                    .then(response => {
                        this.supervisor = response.data;
                        dataStore.commit("signInSupervisor", this.supervisor);
            });
        },

        registerStudentUser() {
// send POST request to service to create user
            dataStore.commit("signIn", this.newUser);
            axios.post(registerApi, this.newUser)
                    .then(() => {
                        window.location = 'studentsignup.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        registerSupervisorUser(){
            dataStore.commit("signIn", this.newUser);
            axios.post(registerApi, this.newUser)
                    .then(() =>{
                        window.location = 'supervisorsignup.html';
                
            })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
            });
        },
        
        supervisorSignIn() {
            this.loginSupervisor(this.newUser.email);
            axios.get(logInApi({'email': this.newUser.email}))
                    .then(response => {
                        if (this.newUser.password === response.data.password) { 
                            this.newUser = response.data;
                            dataStore.commit("signIn", this.newUser);
                            
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
            this.loginStudent(this.newUser.email);
            axios.get(logInApi({'email': this.newUser.email}))
                    .then(response => {
                        if (this.newUser.password === response.data.password) {
                            this.newUser = response.data; 
                            dataStore.commit("signIn", this.newUser);
                            window.location = 'index.html';
                            
                        } else {
                            this.signInMessage = 'Sign in failed.  Check your username and password and try again.';
                        }
                    })
                    .catch(error => {
                        this.signInMessage = 'Sign in failed!  Check your username and password and try again.';
                    });
        },
        
        registerStudent() {
        // send POST request to service to create customer
            this.student.user.email = this.user.email;
            this.student.user.password = this.user.password;
            dataStore.commit("signInStudent", this.student);
            axios.post(studentsApi, this.student)
                    .then(() => {
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        registerSupervisor() {
        // send POST request to service to create customer
            this.supervisor.user.email = this.user.email;
            this.supervisor.user.password = this.user.password;
            dataStore.commit("signInSupervisor", this.supervisor);
            axios.post(supervisorApi, this.supervisor)
                    .then(() => {
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
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
