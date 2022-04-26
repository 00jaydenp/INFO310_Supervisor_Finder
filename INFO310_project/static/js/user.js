/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

"use strict";
var registerApi = '//localhost:8080/api/signup';
var studentApi = ({studentID}) => `//localhost:8080/api/student/${studentID}`;
var supervisorApi = ({supervisorID}) => `//localhost:8080/api/supervisor/${supervisorID}`;
 
const app = Vue.createApp({
 
    data() {
        return {
        supervisor: new Object(),
        student: new Object(),
        signInMessage: "Please sign in to continue."
 
        };
    },
 
    mounted() {
       //alert('Mounted method called');
    },
 
    methods: {
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
 
    supervisorSignIn(){
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
    },
    studentSignIn(){
        alert("Sign In " + this.student.emailAddress + ", " + this.student.password);
        axios.get(studentApi({'Email address': this.student.emailAddress})).then(response => {
            this.student = response.data;
            dataStore.commit("signIn", this.student);
            window.location = 'index.html';
        })
            .catch(error => {
            console.error(error);
            this.signInMessage = 'Sign in failed. Check your email and password and try again.';
    });
    }
 
    }
});
 
// mount the page - this needs to be the last line in the file
import { dataStore } from './data-store.js'
        app.use(dataStore);
app.mount("#content");
