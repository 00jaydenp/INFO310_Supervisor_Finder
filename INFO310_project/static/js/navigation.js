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
        
        studentSignedIn(){
            return this.studentuser !=null;
        },
        
        ...Vuex.mapState({
            user: 'user',
            studentuser: 'studentuser'
        })
    },

    template:
    `
    <nav>
        <div v-if="studentSignedIn">Welcome back {{studentuser.email}}</div>
    <center>
        <a href=".">Home</a>&nbsp
        <a href="project-list.html" v-if="studentSignedIn">Project</a>&nbsp
        <a href="#" v-if="studentSignedIn" @click="signOut()">Sign Out</a>&nbsp
    </center>
    </nav>
    `,

    methods:{
        signOut() {
            sessionStorage.clear();
            window.location = '.';
        }
    }
};  
