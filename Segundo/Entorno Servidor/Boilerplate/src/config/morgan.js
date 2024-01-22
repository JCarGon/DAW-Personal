import morgan from 'morgan';

morgan.format('customFormat', ':method :url :status :res[content-length] - :response-time ms');
