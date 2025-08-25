// 导入三个自定义组件
import Ellipsis from './Ellipsis.vue'
import WDialog from './WDialog.vue'
import Tip from './Tip.vue'

// 导出组件和安装函数
export default {
  // 导出组件，方便单独使用
  Ellipsis,
  WDialog,
  Tip,
  
  // 安装函数，用于Vue.use()注册
  install(Vue) {
    Vue.use(Ellipsis)
    Vue.use(WDialog)
    Vue.use(Tip)
  }
}