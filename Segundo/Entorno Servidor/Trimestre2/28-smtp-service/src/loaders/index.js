import expressLoader from './express-loader.js';
import smtpLoader from './smtp-loader.js';

export default function init(server, config) {
  expressLoader(server);
  smtpLoader(config.smtp);
}
