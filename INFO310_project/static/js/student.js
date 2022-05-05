/* global axios, Vue, Vuex */

"use strict";


var studentIDApi = ({studentID}) => `/api/student/profile/${studentID}`;

const app = Vue.createApp({

    data() {
        return {
            student: new Object({
                user: new Object()
            })
        };
    },
    
    computed: Vuex.mapState({
        user: 'user',
        studentuser: 'studentuser'
    }),


    mounted() {
        this.getStudent(this.studentuser.studentID);
    },

    methods: {
        
       getStudent(studentID) {
            axios.get(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        deleteStudent(studentID){
            axios.delete(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                        sessionStorage.clear();
                        window.location = '.';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        updateStudent(studentID){
            axios.put(studentIDApi({'studentID': studentID}), this.student)
                    .then(() => {
                        window.location = 'studentprofile.html';
                        dataStore.commit("signInStudent", this.student);
                    })
                    .catch(error =>{
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
                    
        }
    }
});

// other component imports go here
import { dataStore } from './data-store.js'
        app.use(dataStore);
        
// import navigation  menu component
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);

// mount the page - this needs to be the last line in the file
app.mount("#content");

