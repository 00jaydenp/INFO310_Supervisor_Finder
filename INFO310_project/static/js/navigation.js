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
        <div v-if="studentSignedIn && signedIn">Welcome back {{studentuser.firstName}}</div>
        <div v-if="supervisorSignedIn && signedIn">Welcome back {{supervisoruser.firstName}}</div>
        <a href=".">Home</a>&nbsp
        <a href ="login.html" v-if="!signedIn">Log In</a>&nbsp
        <a href ="signup.html" v-if="!signedIn">Sign up</a>&nbsp
        <a href="studentprofile.html" v-if="studentSignedIn && signedIn">Profile</a>&nbsp
        <a href="supervisorprofile.html" v-if="supervisorSignedIn && signedIn">Profile</a>&nbsp
        <a href="project-list.html" v-if="signedIn">Project</a>&nbsp
        <a href="#" v-if="signedIn" @click="signOut()">Sign Out</a>&nbsp
    </nav>
    `,

    methods: {
        signOut() {
            sessionStorage.clear();
            window.location = '.';
        }
    }
};
