/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

/* global axios, Vue, Vuex */

"use strict";

var applicationApi = 'api/project/application';
var applicationIDApi = ({applicationID}) => `api/application/${applicationID}`;
var studentIDApi = ({studentID}) => `api/student/application/${studentID}`;
var projectIDApi = ({projectID}) => `api/project/application/${projectID}`;
var studentApi = ({studentID}) => `/api/student/profile/${studentID}`;
var supervisorIDApi = ({staffID}) => `/api/supervisor/profile/${staffID}`;

const app = Vue.createApp({

    data() {
        return {
            applicationByStudent: new Array(),
            applicationByProject: new Array(),
            application: new Object({
                student: new Object(),
                project: new Object()
            }),
            student: new Object({
                user: new Object()
            }),
            
            supervisor: new Object({
                user: new Object()
            })
            
        };
    },
    
    computed: Vuex.mapState({
        studentuser: 'studentuser',
        selectedSupervisor: 'selectedSupervisor',
        selectedProject: 'selectedProject',
        selectedApplication: 'selectedApplication', 
        selectedStudent: 'selectedStudent'
    }),


    mounted() {
        //for viewstudentappliactions
        if (document.URL.includes("viewstudentapplications.html")) {
            this.getApplicationByStudent(this.studentuser.studentID);
        } else if(document.URL.includes("viewsupervisorapplications.html")) {
            this.getApplicationByProject(this.selectedProject.projectID);
        } else if(document.URL.includes("viewselectedproject.html")){
            this.getSupervisor(this.selectedProject.staffID);
        } else if(document.URL.includes("vieweachapplication.html")){
            this.getThisStudent(this.selectedApplication.studentID);
        }
        
    
    },

    methods: {
        registerApplication(studentID, projectID) {
        // send POST request to service to create customer
            this.application.student.studentID = studentID;
            this.application.project.projectID = projectID;
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
                        this.applicationByStudent = response.data;
                    }).catch(error => {
                        console.error(error);
                        alert ("An error occurred - check the console for details");
                    });
        },
        
        getApplicationByProject(projectID){
            axios.get(projectIDApi({'projectID':projectID}))
                    .then(response => {
                        this.applicationByProject = response.data;
                    }).catch(error => {
                        console.error(error);
                        alert ("An error occurred - check the console for details");
                    });
        },
        
        getThisStudent(studentID){
            axios.get(studentApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        addProjectToStudent(studentID, projectID){
            this.student.projectID = projectID;
            axios.put(studentApi({'studentID': studentID}), this.student)
                    .then(() => {
                        alert("success");
                        this.deleteApplications(studentID);
                        window.location.href = "mailto:" + this.student.email + "?subject=Re:%20" + 
                        this.selectedProject.projectID + "%20-%20" + this.selectedProject.name +
                        "&body=Dear%20" + this.student.firstName +", %0D%0AWe%20are%20pleased%20to%20inform" +
                        "%20you%20that%20your%20application%20to%20Project:%20" + this.selectedProject.name
                        + "%20has%20been%20successful%0D%0A%0D%0ASincerely%0D%0ASupervisor%20Finder";
                        window.location = 'viewsupervisorapplications.html';
                    })
                    .catch(error =>{
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
                    
        },
        
        declineApplication(){
            this.deleteApplication(this.selectedApplication.applicationID)
            window.location.href = "mailto:" + this.student.email + "?subject=Re:%20" + 
            this.selectedProject.projectID + "%20-%20" + this.selectedProject.name +
            "&body=Dear%20" + this.student.firstName +", %0D%0AWe%20regret%20to%20inform" +
            "%20you%20that%20your%20application%20to%20Project:%20" + this.selectedProject.name
            + "%20has%20been%20rejected%0D%0A%0D%0ASincerely%0D%0ASupervisor%20Finder";
            window.location = 'viewsupervisorapplications.html';
        },
        
        deleteApplications(studentID){
            axios.delete(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.application = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        deleteApplication(applicationID){
            axios.delete(applicationIDApi({'applicationID': applicationID}))
                    .then(response => {
                        this.application = response.data;
                        window.location = 'viewstudentapplications.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        getSupervisor(staffID) {
            axios.get(supervisorIDApi({'staffID': staffID}))
                    .then(response => {
                        this.supervisor = response.data;
                    }).catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details");
            });
        },
        
        viewApplication(application){
            dataStore.commit("selectApplication", application);
            window.location="vieweachapplication.html";
        },
        
        getStudent(studentID) {
            axios.get(studentApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                        dataStore.commit("selectStudent", this.student);
                        window.location="viewselectedstudent.html";
                    })
                    .catch(error => {
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
