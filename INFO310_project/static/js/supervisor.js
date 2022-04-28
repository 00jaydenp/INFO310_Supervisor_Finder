/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

"use strict";
var supervisorApi = `/api/supervisor/profile`;
//var staffIdApi = '/api/supervisor/profile/$(staffID)';


const app = Vue.createApp({
    data() {
        return{
            supervisors: new Array()
//            supervisor: new Object()
        };
    },
    
    mounted(){
        this.getSupervisor();
    },
    
    methods:{
        getSupervisor(){
            axios.get(supervisorApi).then(response => {
                this.supervisors = response.data;
            }).catch(error => {
                console.error(error);
                alert("An error occurred - check the console for details");            
            });
        }
        
//        getSupervisorById(staffID){
//            axios.get(supervisorApi({'staffID':staffID})).then(response => {
//                this.supervisor = response.data;
//            }).catch(error => {
//                console.error(error);
//                alert ("An error occurred - check the console for details");
//            });
//        }
    }
})
// import navigation  menu component
import { NavigationMenu } from './navigation.js';
app.component('navigation', NavigationMenu);

app.mount("#content");


