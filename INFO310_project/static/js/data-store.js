/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


/* global Vuex */

export const dataStore = Vuex.createStore({

    state () {
        // signed in student
        user: null;
        studentuser: null;
        supervisoruser: null;
        selectedProject: null;
        
    },

    mutations: {

        // user signs in
        signIn(state, user) {
            state.user = user;
        },
        
        signInStudent(state, studentuser) {
            state.studentuser = studentuser;
        },
        
        signInSupervisor(state, supervisoruser) {
            state.supervisoruser = supervisoruser;
        },
        
        //user selected a project
        selectProject(state, project){
            state.selectedProject = project;
        }

    },

    // add session storage persistence
    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});