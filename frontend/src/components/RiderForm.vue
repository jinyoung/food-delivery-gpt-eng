<template>
  <v-form ref="form" v-model="valid" lazy-validation>
    <v-text-field
      v-model="rider.riderId"
      label="라이더 ID"
      :rules="idRules"
      required
    ></v-text-field>
    <v-text-field
      v-model="rider.riderName"
      label="이름"
      :rules="nameRules"
      required
    ></v-text-field>
    <v-select
      v-model="rider.riderStatus"
      :items="statusOptions"
      label="라이더 상태"
      :rules="statusRules"
      required
    ></v-select>
    <v-btn color="success" @click="saveRider">
      저장
    </v-btn>
  </v-form>
</template>

<script>
export default {
  name: 'RiderForm',
  props: {
    rider: Object,
  },
  data: () => ({
    valid: false,
    idRules: [
      v => !!v || '라이더 ID는 필수입니다.',
    ],
    nameRules: [
      v => !!v || '이름은 필수입니다.',
    ],
    statusRules: [
      v => !!v || '라이더 상태는 필수입니다.',
    ],
    statusOptions: ['Available', 'Unavailable', 'OnDelivery'],
  }),
  methods: {
    saveRider() {
      if (this.$refs.form.validate()) {
        this.$emit('save-rider', this.rider);
      }
    },
  },
};
</script>