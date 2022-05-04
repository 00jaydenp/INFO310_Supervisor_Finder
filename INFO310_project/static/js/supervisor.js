/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global axios, Vue, Vuex */

"use strict";

var supervisorApi = '/api/sign-up/supervisor';


const app = Vue.createApp({
    data() {
        return{
            supervisor: new Object({
                user: new Object()
            })
        };
    },
    
    computed: Vuex.mapState({
        user: 'user'
    }),

    
    mounted(){
        //this.getSupervisor();
    },
    
    methods:{
        registerStudent() {
        // send POST request to service to create customer
            this.supervisor.user.email = this.user.email;
            this.supervisor.user.password = this.user.password;
            axios.post(supervisorApi, this.supervisor)
                    .then(() => {
                        window.location = 'index.html';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        }
        
        /*getSupervisor(){
            axios.get(supervisorApi).then(response => {
                this.supervisors = response.data;
            }).catch(error => {
                console.error(error);
                alert("An error occurred - check the console for details");            
            });
        }*/
        
//        getSupervisorById(staffID){
//            axios.get(supervisorApi({'staffID':staffID})).then(response => {
//                this.supervisor = response.data;
//            }).catch(error => {
//                console.error(error);
//                alert ("An error occurred - check the console for details");
//            });
//        }
    }
});

import { dataStore } from './data-store.js'
        app.use(dataStore);
// import navigation  menu component
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);

app.mount("#content");


