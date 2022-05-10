/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global axios, Vue, Vuex */

"use strict";

var applicationApi = 'api/project/application';
var studentIDApi = ({studentID}) => `api/application/${studentID}`;
var projectIDApi = ({projectID}) => `api/project/application/${projectID}`;

const app = Vue.createApp({

    data() {
        return {
            application: new Object({
                student: new Object(),
                project: new Object()
            })
        };
    },
    
    computed: Vuex.mapState({
        studentuser: 'studentuser',
        selectedSupervisor: 'selectedSupervisor',
        selectedProject: 'selectedProject'
    }),


    mounted() {
    },

    methods: {
        registerApplication() {
        // send POST request to service to create customer
            this.application.student.studentID = this.studentuser.studentID;
            this.application.project.projectID = this.selectedProject.projectID;
            axios.post(applicationApi, this.application)
                    .then(() => {
                        window.location = 'index.html';
                        alert("Success");
                    })
                    .catch(error => {
                        console.error(error);
                        alert("You Have Already Applied for this project");
                    });
        },
        
        getApplicationByStudent(studentID){
            axios.get(studentIDApi({'studentID':studentID}))
                    .then(response => {
                        this.application = response.data;
                    }).catch(error => {
                        console.error(error);
                        alert ("An error occurred - check the console for details");
                    });
        },
        
        getApplicationByProject(projectID){
            axios.get(projectIDApi({'projectID':projectID}))
                    .then(response => {
                        this.application = response.data;
                    }).catch(error => {
                        console.error(error);
                        alert ("An error occurred - check the console for details");
                    });
        },

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


