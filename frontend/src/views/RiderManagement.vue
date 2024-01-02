<template>
  <v-container>
    <h1>Rider Management</h1>
    <rider-table
      :riders="riders"
      :loading="loading"
      @view-rider="viewRider"
      @edit-rider="editRider"
      @delete-rider="deleteRider"
    ></rider-table>
    <rider-form
      v-if="showForm"
      :rider="currentRider"
      @save-rider="saveRider"
    ></rider-form>
    <!-- Additional UI elements for CRUD operations -->
  </v-container>
</template>

<script>
import axios from 'axios';
import RiderTable from '../components/RiderTable.vue';
import RiderForm from '../components/RiderForm.vue';

export default {
  name: 'RiderManagement',
  components: {
    RiderTable,
    RiderForm,
  },
  data: () => ({
    riders: [],
    loading: false,
    showForm: false,
    currentRider: null,
  }),
  methods: {
    fetchRiders() {
      this.loading = true;
      axios.get('/riders')
        .then(response => {
          this.riders = response.data;
        })
        .catch(error => {
          console.error(error);
        })
        .finally(() => {
          this.loading = false;
        });
    },
    viewRider(rider) {
      this.currentRider = rider;
      this.showForm = true;
    },
    editRider(rider) {
      this.currentRider = rider;
      this.showForm = true;
    },
    saveRider(rider) {
      const method = rider.riderId ? 'patch' : 'post';
      const url = rider.riderId ? `/riders/${rider.riderId}` : '/riders';
      axios[method](url, rider)
        .then(() => {
          this.fetchRiders();
          this.showForm = false;
        })
        .catch(error => {
          console.error(error);
        });
    },
    deleteRider(rider) {
      axios.delete(`/riders/${rider.riderId}`)
        .then(() => {
          this.fetchRiders();
        })
        .catch(error => {
          console.error(error);
        });
    },
  },
  mounted() {
    this.fetchRiders();
  },
};
</script>