<template>
  <v-data-table
    :headers="headers"
    :items="riders"
    item-key="riderId"
    class="elevation-1"
    :loading="loading"
    @click:row="viewRider"
  >
    <template v-slot:[`item.actions`]="{ item }">
      <v-icon small class="mr-2" @click="editRider(item)">
        mdi-pencil
      </v-icon>
      <v-icon small @click="deleteRider(item)">
        mdi-delete
      </v-icon>
    </template>
  </v-data-table>
</template>

<script>
export default {
  name: 'RiderTable',
  props: {
    riders: Array,
    loading: Boolean
  },
  data: () => ({
    headers: [
      { text: '라이더 ID', value: 'riderId' },
      { text: '이름', value: 'riderName' },
      { text: '라이더 상태', value: 'riderStatus' },
      { text: 'Actions', value: 'actions', sortable: false },
    ],
  }),
  methods: {
    viewRider(rider) {
      this.$emit('view-rider', rider);
    },
    editRider(rider) {
      this.$emit('edit-rider', rider);
    },
    deleteRider(rider) {
      this.$emit('delete-rider', rider);
    },
  },
};
</script>