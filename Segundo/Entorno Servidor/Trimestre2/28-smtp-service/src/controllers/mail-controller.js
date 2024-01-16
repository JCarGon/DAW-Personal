import { send } from '../services/smtp-service.js';

export default async function mailController(req, res, next) {
  try {
    await send(req.body);
    res.json({ succes: true });
  } catch (err) {
    next(err);
  }
}
