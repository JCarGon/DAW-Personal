/* eslint-disable consistent-return */
/* eslint-disable no-console */
// eslint-disable-next-line import/no-extraneous-dependencies
import { Resend } from 'resend';

const resend = new Resend('re_j5ptX1cC_Cv3awXBUAjoqtzvDMViX3EKd');

export default async function resendMail() {
  const { data, error } = await resend.emails.send({
    from: 'Jesus <jesus@resend.dev>',
    to: ['jesuscarrillogonzalez.93@gmail.com'],
    subject: 'Hello World',
    html: '<strong>It works!</strong>',
  });

  if (error) {
    return console.error({ error });
  }

  console.log({ data });
}
