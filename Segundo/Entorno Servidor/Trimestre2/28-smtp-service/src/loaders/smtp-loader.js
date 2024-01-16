import { init } from '../services/smtp-service.js';

// eslint-disable-next-line func-names
export default function (config) {
  init(config);
}
