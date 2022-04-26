"use strict";

var studentsApi = '/api/student/profile';
var studentIDApi = ({studentID}) => `//localhost:8090/api/student/profile/${studentID}`;
//var logInApi = ({email}) => `//localhost:8090/api/login/${email}`;

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
            students: new Array(),
            student: new Object()

        };
    },

    mounted() {
        // semicolon separated statements

        this.getAllStudents();
        //this.getStudent(studentID);

    },

    methods: {
        // comma separated function declarations
        getAllStudents() {

            axios.get(studentsApi)
                    .then(response => {
                        this.students = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },

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

        /*saveStudents() {
            axios.post(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },*/
        
        saveStudent() {
// send POST request to service to create customer
            axios.post(studentsApi, this.student)
                    .then(() => {
                        window.location = 'index.html';

                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        /*deleteStudent(studentID){
            axios.delete(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
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

