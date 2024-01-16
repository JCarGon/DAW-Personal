import dotenv from 'dotenv';

dotenv.config();

const config = {
  port: process.env.PORT,
  smtp: {
    host: process.env.SMTP_HOST,
    port: process.env.SMTP_PORT,
    user: process.env.SMTP_USER,
    pass: process.env.SMTP_PASS,
  },
};

export default config;
