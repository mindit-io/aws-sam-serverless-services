'use strict';

const app = require('../../app.js');
const chai = require('chai');
const expect = chai.expect;
var context;
var event = {	
    name: 'Henri Coanda',
    wiki: 'https://en.wikipedia.org/wiki/Henri_Coand%C4%83',
    knownFor: 'first jet engine, Coandă effect'
}
    
    

describe('Tests index', function () {
    it('verifies successful response', async () => {
        const result = await app.lambdaHandler(event, context)

        expect(result).to.be.an('object');
        expect(result.statusCode).to.equal(200);
        expect(result.body).to.be.an('string');

        let response = JSON.parse(result.body);
        expect(response).to.be.an('object');

        expect(response.event.name).to.be.equal('Henri Coanda');
        expect(response.event.wiki).to.be.equal('https://en.wikipedia.org/wiki/Henri_Coand%C4%83');
        expect(response.event.knownFor).to.be.equal('first jet engine, Coandă effect');
    });
});
