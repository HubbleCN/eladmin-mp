import { constantRouterMap } from '@/router/routers'
import Layout from '@/layout/index'
import ParentView from '@/components/ParentView'

const flow = {
  state: {
    nodeMap: new Map(),
    isEdit: null,
    selectedNode: {},
    selectFormItem: null,
    design: {}
  },
  mutations: {
    selectedNode(state, val) {
      state.selectedNode = val
    },
    loadForm(state, val) {
      state.design = val
    },
    setIsEdit(state, val) {
      state.isEdit = val
    }
  },
  getters: {},
  actions: {},
  modules: {}
}

export default flow
