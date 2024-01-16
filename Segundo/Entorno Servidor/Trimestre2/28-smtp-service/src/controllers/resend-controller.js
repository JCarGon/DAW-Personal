import resendMail from '../services/resend-service.js';

export default async function mailToController() {
  await resendMail();
}
