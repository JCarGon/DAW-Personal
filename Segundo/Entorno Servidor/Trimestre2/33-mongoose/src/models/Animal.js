import mongoose from "mongoose";

const { Schema } = mongoose;

const animalSchema = new Schema({
  name: { type: String, required: true, unique: true },
  color: String, enum: ['rojo', 'azul', 'amarillo'], //color: [String] se convierte en un array colores
  legs: String,
  hasTail: Boolean,
  age: Number,
}, { timestamps: true });

export default mongoose.model('Animal', animalSchema);
