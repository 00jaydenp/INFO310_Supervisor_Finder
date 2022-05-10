/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global axios, Vue, Vuex */

"use strict";

var projectsApi = '//localhost:8090/api/projects';
var addProjectApi = '//localhost:8090/api/supervisor/projects';
var projectIDApi = ({projectID}) => `//localhost:8090/api/projects/${projectID}`;
var getByStaffIDApi = ({staffID}) => `//localhost:8090/api/supervisor/projects/${staffID}`;
var projectQueryApi = ({query}) => `//localhost:8090/api/projects/search/${query}`;

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
            query: "",
            projectsArr: new Array(),
            projectByStaff: new Array(),
            project: new Object({
                supervisor: new Object()
            })

        };
    },

    computed: Vuex.mapState({
        selectedProject: 'selectedProject',
        supervisoruser: 'supervisoruser'
    }),

    mounted() {
        // semicolon separated statements

        if (document.URL.includes("myproject.html")) {
            this.getByStaffID(this.supervisoruser.staffID);
        } else if (document.URL.includes("supervisoreditproject.html")) {
            this.getProject(this.selectedProject.projectID);
        } else {
            this.getAllProjects();
        }
        
       

    },

    methods: {

        getAllProjects() {
            axios.get(projectsApi)
                    .then(response => {
                        this.projectsArr = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },

        getByStaffID(staffID) {
            axios.get(getByStaffIDApi({'staffID': staffID}))
                    .then(response => {
                        this.projectByStaff = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("You do not have a project yet");
                    });
        },

        // comma separated function declarations
        addProject() {
            this.project.supervisor.staffID = this.supervisoruser.staffID;
            var date = new Date();
            var day = date.getDate();
            var month = date.getMonth() + 1;
            var year = date.getFullYear();
            var fulldate = day + "/" + month + "/" + year;
            this.project.date = fulldate;
            dataStore.commit("selectProject", this.project);
            axios.post(addProjectApi, this.project)
                    .then(() => {
                        window.location = 'myproject.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
            this.project = {};
        },

        pickProject(project) {
            dataStore.commit("selectProject", project);
            window.location = "viewselectedproject.html";
        },

        staffPickProject(project) {
            dataStore.commit("selectProject", project);
            window.location = "supervisorviewproject.html";
        },

        getProject(projectID) {
            axios.get(projectIDApi({'projectID': projectID}))
                    .then(response => {
                        this.project = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },

        //click handler to delete project 
        deleteProject(projectID) {
            axios.delete(projectIDApi({'projectID': projectID}))
                    .then(response => {
                        this.project = response.data;
                        window.location = 'myproject.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },

        updateProject(projectID) {
            axios.put(projectIDApi({'projectID': projectID}), this.project)
                    .then(() => {
                        //this.project = response.data;
                        window.location = 'myproject.html';
                        dataStore.commit("selectedProject", this.project);
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },

        getProjectByQuery() {
            axios.get(projectQueryApi({'query': this.query}))
                    .then(response => {
                        this.projectsArr = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
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
