import mongoose from "mongoose";

const { Schema } = mongoose;

const animalSchema = new Schema({
  name: String,
  color: String,
  legs: String,
  hasTail: Boolean,
  age: Number,
}, { timestamps: true });

export default mongoose.model('Animal', animalSchema);
