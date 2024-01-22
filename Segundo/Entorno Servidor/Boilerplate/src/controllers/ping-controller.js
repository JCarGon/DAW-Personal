import pingService from '../services/pingServices/ping.js';

export default function pingController(req, res) {
  pingService(req, res);
}
