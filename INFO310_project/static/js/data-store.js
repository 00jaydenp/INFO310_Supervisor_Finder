/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */


export const dataStore = Vuex.createStore({

    state () {
        // signed in student
        user: null;
        
    },

    mutations: {

        // user signs in
        logIn(state, user) {
            state.user = user;
            //state.items = new Array();
        }

    },

    // add session storage persistence
    plugins: [window.createPersistedState({storage: window.sessionStorage})]

});