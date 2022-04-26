/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


export const dataStore = Vuex.createStore({

    state () {
        // signed in student
        student: null;
        
    },

    mutations: {

        // user signs in
        signIn(state, student) {
            state.student = student;
            //state.items = new Array();
        }

    },

    // add session storage persistence
    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});