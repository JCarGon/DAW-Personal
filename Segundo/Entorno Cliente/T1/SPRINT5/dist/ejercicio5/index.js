"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
document.addEventListener('DOMContentLoaded', () => {
    const button = document.querySelector('button');
    button === null || button === void 0 ? void 0 : button.addEventListener('click', buscarPokemon);
});
function buscarPokemon() {
    return __awaiter(this, void 0, void 0, function* () {
        const input = document.querySelector('input');
        const pokemonNameOrNumber = input === null || input === void 0 ? void 0 : input.value;
        if (!pokemonNameOrNumber) {
            alert('Introduce un nombre o número de Pokémon válido.');
            return;
        }
        try {
            // Obtener información del Pokémon
            const pokemonResponse = yield fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonNameOrNumber}`);
            const pokemonData = yield pokemonResponse.json();
            // Obtener información de la cadena evolutiva
            const speciesResponse = yield fetch(pokemonData.species.url);
            const speciesData = yield speciesResponse.json();
            const evolutionChainResponse = yield fetch(speciesData.evolution_chain.url);
            const evolutionChainData = yield evolutionChainResponse.json();
            // Obtener sprites de la cadena evolutiva
            const evolutionSprites = yield obtenerSpritesCadenaEvolutiva(evolutionChainData.chain);
            // Actualizar los elementos del DOM con los resultados
            actualizarImagen(pokemonData.sprites.front_default);
            actualizarStats(pokemonData.stats);
            actualizarTipo('type1-Pokemon', pokemonData.types[0]);
            actualizarTipo('type2-Pokemon', pokemonData.types[1]);
            actualizarNombre(pokemonData.id, pokemonData.name);
            actualizarMovimientos(pokemonData.moves);
            actualizarCadenaEvolutiva(evolutionSprites);
        }
        catch (error) {
            console.error('Error al buscar el Pokémon:', error);
            alert('No se encontró el Pokémon. Inténtalo de nuevo.');
        }
    });
}
function obtenerSpritesCadenaEvolutiva(chainData) {
    return __awaiter(this, void 0, void 0, function* () {
        const evolutionSprites = [];
        function obtenerSpritesRecursivo(evolutionDetails) {
            return __awaiter(this, void 0, void 0, function* () {
                // Obtener el nombre del Pokémon desde la URL en lugar de la especie
                const pokemonName = obtenerNombreDesdeUrl(evolutionDetails.species.url);
                yield obtenerSprite(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`, evolutionSprites);
                // Usar Promise.all para esperar a que todas las llamadas a obtenerSpritesRecursivo se completen
                yield Promise.all(evolutionDetails.evolves_to.map((evolution) => obtenerSpritesRecursivo(evolution)));
            });
        }
        // Llamar a obtenerSpritesRecursivo y esperar a que todas las operaciones asíncronas se completen
        yield obtenerSpritesRecursivo(chainData);
        // Devolver el array después de que todas las operaciones asíncronas hayan terminado
        return evolutionSprites;
    });
}
function obtenerNombreDesdeUrl(url) {
    // Extraer el nombre del Pokémon desde la URL
    const parts = url.split('/');
    return parts[parts.length - 2];
}
function obtenerSprite(url, evolutionSprites) {
    return __awaiter(this, void 0, void 0, function* () {
        try {
            const response = yield fetch(url);
            const data = yield response.json();
            // Verificar si la propiedad 'sprites' existe
            if (data.sprites && data.sprites.front_default) {
                evolutionSprites.push(data.sprites.front_default);
            }
            else {
                console.warn(`No se encontró el sprite para ${data.name}`);
            }
        }
        catch (error) {
            console.error(`Error al obtener el sprite para ${url}`, error);
        }
    });
}
function actualizarCadenaEvolutiva(sprites) {
    const evosPokemon = document.querySelector('.evos-Pokemon');
    evosPokemon.innerHTML = '<h2>Cadena Evolutiva</h2>';
    // Crear un contenedor para los sprites y aplicar estilos
    const spritesContainer = document.createElement('div');
    spritesContainer.style.display = 'flex';
    spritesContainer.style.flexDirection = 'column';
    spritesContainer.style.alignItems = 'center';
    sprites.forEach((spriteUrl) => {
        const spriteElement = document.createElement('div');
        spriteElement.style.backgroundImage = `url(${spriteUrl})`;
        spriteElement.style.backgroundSize = 'contain';
        spriteElement.style.backgroundRepeat = 'no-repeat';
        spriteElement.style.backgroundPosition = 'center';
        spriteElement.style.width = '100px';
        spriteElement.style.height = '100px';
        // Agregar cada sprite al contenedor
        spritesContainer.appendChild(spriteElement);
    });
    // Agregar el contenedor de sprites al div principal
    evosPokemon.appendChild(spritesContainer);
    evosPokemon.style.display = 'flex';
    evosPokemon.style.flexDirection = 'column';
    evosPokemon.style.alignItems = 'center';
    evosPokemon.style.justifyContent = 'center';
}
function actualizarImagen(spriteUrl) {
    const imgPokemon = document.querySelector('.img-Pokemon');
    if (spriteUrl) {
        imgPokemon.style.backgroundImage = `url(${spriteUrl})`;
        imgPokemon.style.backgroundSize = 'contain';
        imgPokemon.style.backgroundRepeat = 'no-repeat';
        imgPokemon.style.backgroundPosition = 'center';
    }
    else {
        imgPokemon.style.backgroundImage = 'none';
    }
}
function actualizarNombre(numPokedex, namePokemon) {
    const namePokemonDiv = document.querySelector('.name-Pokemon');
    namePokemonDiv.innerHTML = `<div>Nº: ${numPokedex}</div><div>${namePokemon}</div>`;
    namePokemonDiv.style.display = 'flex';
    namePokemonDiv.style.flexDirection = 'column';
    namePokemonDiv.style.alignItems = 'center';
    namePokemonDiv.style.justifyContent = 'center';
}
function actualizarTipo(typeContainer, typeData) {
    const typePokemon = document.querySelector(`.${typeContainer}`);
    if (typeData) {
        const typeName = typeData.type.name;
        const typeImagePath = `imgs/types/${typeName}.svg`;
        typePokemon.style.backgroundImage = `url(${typeImagePath})`;
        typePokemon.style.backgroundSize = '80% 80%';
        typePokemon.style.backgroundRepeat = 'no-repeat';
        typePokemon.style.backgroundPosition = 'center';
        typePokemon.textContent = '';
    }
    else {
        typePokemon.style.backgroundImage = 'none';
        typePokemon.textContent = '';
    }
    typePokemon.style.display = 'flex';
    typePokemon.style.alignItems = 'center';
    typePokemon.style.justifyContent = 'center';
}
function actualizarStats(stats) {
    const dataPokemon = document.querySelector('.data-Pokemon');
    dataPokemon.innerHTML = '';
    // Crear contenedor para las estadísticas y aplicar estilos
    const statsContainer = document.createElement('div');
    statsContainer.innerHTML = '<h2>Stats</h2>';
    statsContainer.style.display = 'flex';
    statsContainer.style.flexDirection = 'column';
    statsContainer.style.alignItems = 'center';
    stats.forEach((stat) => {
        const statElement = document.createElement('div');
        statElement.textContent = `${stat.stat.name}: ${stat.base_stat}`;
        statElement.style.textAlign = 'center';
        statsContainer.appendChild(statElement);
    });
    // Agregar el contenedor de estadísticas al div principal
    dataPokemon.appendChild(statsContainer);
}
function actualizarMovimientos(moves) {
    const dataPokemon = document.querySelector('.data-Pokemon');
    // Crear contenedor para los movimientos y aplicar estilos
    const movesContainer = document.createElement('div');
    movesContainer.innerHTML = '<h2>Ataques</h2>';
    movesContainer.style.display = 'flex';
    movesContainer.style.flexDirection = 'column';
    movesContainer.style.alignItems = 'center';
    moves.forEach((move) => {
        const moveElement = document.createElement('div');
        moveElement.textContent = move.move.name;
        moveElement.style.textAlign = 'center';
        movesContainer.appendChild(moveElement);
    });
    // Agregar el contenedor de movimientos al div principal
    dataPokemon.appendChild(movesContainer);
    // Agregar la propiedad overflow-y: auto; para habilitar el scroll vertical
    dataPokemon.style.overflowY = 'auto';
}
