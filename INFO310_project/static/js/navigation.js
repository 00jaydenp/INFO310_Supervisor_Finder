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
        ...Vuex.mapState({
            user: 'user'
        })
    },

    template:
    `
    <nav>
        <div v-if="signedIn">Welcome back {{user.student.firstName}}</div>
    <center>
        <a href=".">Home</a>&nbsp
        
        
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
