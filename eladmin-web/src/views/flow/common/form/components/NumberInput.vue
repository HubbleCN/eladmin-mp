<template>
  <div>
    <div v-if="mode === 'DESIGN'">
      <el-input size="medium" disabled :placeholder="placeholder" type="number" />
    </div>
    <div v-else>
      <el-input v-model="_value" size="medium" clearable :placeholder="placeholder" type="number" />
    </div>
  </div>
</template>

<script>
import componentMinxins from '../ComponentMinxins'

export default {
  name: 'NumberInput',
  components: {},
  mixins: [componentMinxins],
  props: {
    value: {
      type: Number,
      default: null
    },
    placeholder: {
      type: String,
      default: '请输入数值'
    }
  },
  data() {
    return {}
  },
  methods: {}
}
</script>

<style scoped>

</style>
