/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

"use strict";

var projectsApi = 'api/projects';
var addProjectApi = 'api/supervisor/projects';

//var getByIDApi = ({projectID}) ='api/projects/${projectID}';
//var getByStaffIDApi = ({staffID}) ='api/supervisor/projects/${staffID}';

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
            projects: new Array()
            //project: new Object()           
        };
    },

    mounted() {
        // semicolon separated statements

        //alert('Mounted method called');
        this.getAllProjects();

    },

    methods: {
        
        getAllProjects() {

            axios.get(projectsApi)
                    .then(response => {
                        this.projects = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },
        // comma separated function declarations
        /*addProject() {
            axios.post(addProjectApi, this.project)
                    .then(() => {
                        window.location = 'addproject.html'
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        //enter project ID to get the project 
        getProjectByID(projectID) {
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
        },
        
        getProjectByStaffID(staffID) {
            axios.get(getByStaffIDApi({'staffID': this.supervisor.staffID}))
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


// mount the page - this needs to be the last line in the file
app.mount("#content");