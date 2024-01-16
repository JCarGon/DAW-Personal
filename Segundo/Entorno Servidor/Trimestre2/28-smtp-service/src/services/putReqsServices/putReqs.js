import { Logger } from 'winston';

export default async function postToPutReq(datas) {
  const options = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(datas),
  };
  try {
    // cambiar la url para hacer pruebas, se resetea cuando se cierra
    await fetch('https://putsreq.com/Ltb2q134qo5Qg10Urahi', options);
  } catch (err) {
    Logger.info(err);
  }
}
