<template>
  <div class="body">
    <div class="top">
      꿀조합 찜 목록
    </div>
    <sand-big-list></sand-big-list>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import SandBigList from '../../components/common/SandBigList.vue'
export default {
  components: { SandBigList },
  name: 'ZzimView',

  computed: {
    ...mapGetters(['profile'])
  },

  methods: {
    
    ...mapActions(['fetchDibList', 'fetchProfile']),
  },

  mounted () {
    this.fetchProfile().then(
      this.fetchDibList(this.profile.userName)
    )
  }
}
</script>

<style scoped>
.body {
  padding-top: 46px;
}
.top {
  height: 46px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  background-color: white;
}

</style>