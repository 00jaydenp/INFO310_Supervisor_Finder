/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global axios, Vue, Vuex */

"use strict";

var projectsApi = '//localhost:8090/api/projects';
var addProjectApi = '//localhost:8090/api/supervisor/projects';
//var projectByStaff = '/api/supervisor/projects';
var projectByID = ({projectID}) => '//localhost:8090/api/projects/{projectID}';

//var getByIDApi = ({projectID}) ='api/projects/${projectID}';
//var getByStaffIDApi = ({staffID}) ='api/supervisor/projects/${staffID}';

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
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

        //alert('Mounted method called');
        this.getAllProjects();
        //this.filterByProjectID(this.selectedProject.projectID);
        //this.getProjectByStaffID();

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
        
        filterByProjectID(projectID) {
            axios.get(project({'projectID': projectID}))
                    .then(response => {
                        this.project = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        // comma separated function declarations
        addProject() {
            
            this.project.supervisor.staffID = this.supervisoruser.staffID;
            dataStore.commit("selectProject", this.project);
            axios.post(addProjectApi, this.project)
                    .then(() => {
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        pickProject(project){
            dataStore.commit("selectProject", project);
            window.location="viewselectedproject.html";
        }
        
        //enter project ID to get the project 
    /*    getProjectByID(projectID) {
            axios.get(getByIDApi({'projectID': projectID}))
                    .then(response => {
                        this.project = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        }, 
        
        //click handler to delete project 
        deleteProjectByID(projectID) {
            axios.delete(getByIDApi({'projectID': projectID}))
                    .then(response => {
                        this.project = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        updateProjectByID(projectID) {
            axios.put(getByIDApi({'projectID': projectID}))
                    .then(response => {
                        this.project = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },*/
        
        /*getProjectByStaffID() {
            axios.get(projectByStaff({'staffID': this.supervisor.staffID}))
                    .then(response => {
                        this.project = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        }*/
        

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
