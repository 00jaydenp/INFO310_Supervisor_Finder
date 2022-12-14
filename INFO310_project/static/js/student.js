/* global axios, Vue, Vuex */

"use strict";


var studentIDApi = ({studentID}) => `/api/student/profile/${studentID}`;
var studentsApi = `//localhost:8090/api/student/profile`;

const app = Vue.createApp({

    data() {
        return {
            studentsArr: new Array(),
            student: new Object({
                user: new Object(),
                project: new Object()
            }),
            studentID: ""
        };
    },
    
    computed: Vuex.mapState({
        user: 'user',
        studentuser: 'studentuser',
        selectedStudent: 'selectedStudent',
        selectedApplication: 'selectedApplication',
//        studentApplication: 'studentApplication' //fix here
        
    }),


    mounted() {
        //this.getStudent(this.studentuser.studentID);
        if (document.URL.includes("studentlist.html")) {
            this.getAllStudents();
        } else if (document.URL.includes("viewselectedstudent.html")) {
            //don't mount
        } else if(document.URL.includes("selectedstudentfromapplication.html")){
            //don't mount 
//            dataStore.commit("studentApp", this.getStudent(this.studentuser.studentID));
        }else {
            this.getStudent(this.studentuser.studentID);
        }

    },

    methods: {
        
        getAllStudents() {
            axios.get(studentsApi)
                    .then(response => {
                        this.studentsArr = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },
        
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
        
        pickStudent(student){
            dataStore.commit("selectStudent", student);
            window.location="viewselectedstudent.html";
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
                    
        },
        
        searchStudent(){
            if(this.studentID === ""){
                alert("Please Enter an ID");
            } else {
                axios.get(studentIDApi({'studentID': this.studentID}))
                        .then(response => {
                            this.studentsArr = new Array();
                            this.studentsArr[0] = response.data;
                        })
                        .catch(error => {
                            console.error(error);
                            alert("No student found with that ID");
                        });
            }
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

