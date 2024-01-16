import postToPutReq from '../services/putReqsServices/putReqs.js';

export default async function postPutReq(req, res) {
  await postToPutReq(req.body);
  res.status(200).send(req.body);
}
