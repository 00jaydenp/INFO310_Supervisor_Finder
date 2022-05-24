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
        selectedStudent: null;
        selectedSupervisor: null;
        selectedApplication: null;
        
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
        },
        
        selectStudent(state, studentuser){
            state.selectedStudent = studentuser;
        },
        
        selectSupervisor(state, supervisoruser){
            state.selectedSupervisor = supervisoruser;
        },
        
        selectApplication(state, application){
            state.selectedApplication = application;
        }

    },

    // add session storage persistence
    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});