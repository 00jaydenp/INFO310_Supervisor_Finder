"use strict";

var studentsApi = '/api/student/profile';
//var studentIDApi = ({studentID}) => '/api/student/profile/${studentID}';

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
            students: new Array()
            //student: new Object()

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

        }

        /*getStudent(studentID) {

            axios.get(studentIDApi({'studentID': studentID}))
                    .then(response => {
                        this.student = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        }, 
        
        updateStudent(studentID){
            axios.put(studentIDApi({'studentID': studentID}))
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

