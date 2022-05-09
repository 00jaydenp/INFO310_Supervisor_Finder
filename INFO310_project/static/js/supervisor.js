/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global axios, Vue, Vuex */

"use strict";


var supervisorIDApi = ({staffID}) => `/api/supervisor/profile/${staffID}`;
var supervisorApi = "//localhost:8082/api/supervisor/profile"


const app = Vue.createApp({
    data() {
        return{
            supervisorArr: new Array(),
            supervisor: new Object({
                user: new Object()
            })
        };
    },
    
    computed: Vuex.mapState({
        user: 'user',
        selectedSupervisor: 'selectedSupervisor',
        supervisoruser: 'supervisoruser'
    }),

    
    mounted(){
        this.getSupervisor(this.supervisoruser.staffID);
        this.getAllSupervisors();
        
    },
    
    methods:{
        
        getAllSupervisors() {
            axios.get(supervisorApi)
                    .then(response => {
                        this.supervisorArr = response.data;
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });

        },
        
        
        getSupervisor(staffID){
            axios.get(supervisorIDApi({'staffID':staffID}))
                    .then(response => {
                        this.supervisor = response.data;
                    }).catch(error => {
                        console.error(error);
                        alert ("An error occurred - check the console for details");
                    });
        },
        
        deleteSupervisor(staffID){
            axios.delete(supervisorIDApi({'staffID': staffID}))
                    .then(response => {
                        this.supervisor = response.data;
                        sessionStorage.clear();
                        window.location = '.';
                    })
                    .catch(error => {
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
        },
        
        updateSupervisor(staffID){
            axios.put(supervisorIDApi({'staffID': staffID}), this.supervisor)
                    .then(() => {
                        window.location = 'supervisorprofile.html';
                        dataStore.commit("signInSupervisor", this.supervisor);
                    })
                    .catch(error =>{
                        console.error(error);
                        alert("An error occurred - check the console for details.");
                    });
                    
        },
        
        pickSupervisor(supervisor){
            dataStore.commit("selectSupervisor", supervisor);
            window.location="viewselectedsupervisor.html";
        }
    }
});

import { dataStore } from './data-store.js'
        app.use(dataStore);
// import navigation  menu component
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);

app.mount("#content");
