"use strict";

var studentsApi = '/api/student/profile';

const app = Vue.createApp({

    data() {
        return {
            // models (comma separated key/value pairs)
            students: new Array()

        };
    },

    mounted() {
        // semicolon separated statements

        this.getAllStudents();

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

    }

});

// other component imports go here


// mount the page - this needs to be the last line in the file
app.mount("#content");

