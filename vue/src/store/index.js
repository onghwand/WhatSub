import Vue from 'vue'
import Vuex from 'vuex'
import accounts from './modules/accounts'
import combination from './modules/combination'
import common from './modules/common'
import order from './modules/order'
// import createPersistedState from "vuex-persistedstate"
Vue.use(Vuex)

export default new Vuex.Store({
  // plugins: [createPersistedState({
  // })],

  state: {
    bottomValue: 1,
  },
  getters: {
    bottomValue: (state) => state.bottomValue,
  },
  mutations: {
    SET_BOTTOMVALUE: (state, value) => (state.bottomValue = value),
  },
  actions: {
    fetchBottomValue({ commit }, value) {
      commit("SET_BOTTOMVALUE", value);
    },
  },
  modules: { accounts, combination, common, order
  }

})
