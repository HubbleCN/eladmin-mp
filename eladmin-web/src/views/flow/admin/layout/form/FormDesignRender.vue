<template>
  <component :is="config.name" ref="form" v-model="_value" :mode="mode" v-bind="config.props" />
</template>
<script>

import components from '@/views/flow/common/form/ComponentExport'

export default {
  name: 'FormRender',
  components: components,
  props: {
    mode: {
      type: String,
      default: 'DESIGN'
    },
    value: {
      default: undefined
    },
    config: {
      type: Object,
      default: () => {
        return {}
      }
    }
  },
  data() {
    return {}
  },
  computed: {
    _value: {
      get() {
        return this.value
      },
      set(val) {
        this.$emit('input', val)
      }
    }
  },
  methods: {
    validate(call) {
      this.$refs.form.validate(call)
    }
  }
}
</script>

<style lang="scss" scoped>

</style>
