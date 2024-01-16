/* eslint-disable no-unused-vars */
/* eslint-disable no-console */
// eslint-disable-next-line import/no-extraneous-dependencies
import nodemailer from 'nodemailer';

let transporter = null;

export function init(config) {
  const smtpConfig = {
    host: config.host,
    port: config.port,
    secure: false,
  };
  if (config.user) {
    smtpConfig.auth = {
      user: config.user,
      pass: config.pass,
    };
  }

  transporter = nodemailer.createTransport(smtpConfig);

  transporter.verify((error, success) => {
    if (error) {
      console.log(error);
    } else {
      console.log('SMTP ready');
    }
  });
}

export async function send(mailOptions) {
  return transporter.sendMail({
    from: transporter.options.auth.user,
    ...mailOptions,
  });
}
