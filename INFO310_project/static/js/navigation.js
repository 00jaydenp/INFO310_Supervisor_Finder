/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

"use strict";

// import data store
import { dataStore } from './data-store.js'

export const NavigationMenu = {

    computed: {
        signedIn() {
            return this.user != null;
        },

        studentSignedIn() {
            return this.studentuser != null;
        },
        
        supervisorSignedIn() {
            return this.supervisoruser != null;
        },

        ...Vuex.mapState({
            user: 'user',
            studentuser: 'studentuser',
            supervisoruser: 'supervisoruser'   
        })
    },

    template:
            `
    <nav>
        <img src="images/Uni-Logo.png">
        <div class="message" v-if="studentSignedIn && signedIn">Welcome back {{studentuser.firstName}}</div>
        <div class="message" v-if="supervisorSignedIn && signedIn">Welcome back {{supervisoruser.firstName}}</div>
        <div class="nav_links">
            <a class="nav_button" href=".">Home</a>&nbsp
            <a class="nav_button" href ="login.html" v-if="!signedIn">Log In</a>&nbsp
            <a class="nav_button" href ="signup.html" v-if="!signedIn">Sign up</a>&nbsp
            <a class="nav_button" href ="studentlist.html" v-if="signedIn && supervisorSignedIn">Student List</a>&nbsp
            <a class="nav_button" href ="supervisorlookup.html" v-if="signedIn && studentSignedIn">Supervisor List</a>&nbsp
            <a class="nav_button" href="studentprofile.html" v-if="studentSignedIn && signedIn">Profile</a>&nbsp
            <a class="nav_button" href="supervisorprofile.html" v-if="supervisorSignedIn && signedIn">Profile</a>&nbsp
            <a class="nav_button" href="project-list.html" v-if="studentSignedIn && signedIn">Project</a>&nbsp
            <a class="nav_button" href="viewstudentapplications.html" v-if="studentSignedIn && signedIn">Applications</a>&nbsp
            <a class="nav_button" href="myproject.html" v-if="supervisorSignedIn && signedIn">My Project</a>&nbsp
            <a class="nav_button" href="addproject.html" v-if="supervisorSignedIn && signedIn">Add Project</a>&nbsp
            <a class="nav_button" href="#" v-if="signedIn" @click="signOut()">Sign Out</a>&nbsp
        </div>
    </nav>
    `,

    methods: {
        signOut() {
            sessionStorage.clear();
            window.location = '.';
        }
    }
};
