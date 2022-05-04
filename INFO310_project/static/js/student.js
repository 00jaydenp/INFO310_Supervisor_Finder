/* global axios, Vue, Vuex */

"use strict";

var studentsApi = '/api/sign-up/student';
var studentIDApi = ({studentID}) => `//localhost:8090/api/student/profile/${studentID}`;

const app = Vue.createApp({

    data() {
        return {
            student: new Object({
                user: new Object()
            })
        };
    },
    
    computed: Vuex.mapState({
        user: 'user'
    }),


    mounted() {
    },

    methods: {
        
       /*getStudent(studentID) {
            axios.get(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },*/

        registerStudent() {
        // send POST request to service to create customer
            this.student.user.email = this.user.email;
            this.student.user.password = this.user.password;
            axios.post(studentsApi, this.student)
                    .then(() => {
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        }
        
        /*deleteStudent(studentID){
            axios.delete(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },*/
        
        /*updateStudent(studentID){
            axios.put(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                    })
                    .catch(error =>{
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        }*/
    }
});

// other component imports go here
import { dataStore } from './data-store.js'
        app.use(dataStore);

// mount the page - this needs to be the last line in the file
app.mount("#content");

