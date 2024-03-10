package main

import (
	"bufio"
	"encoding/gob"
	"io"
	"net/http"
)

type GobCodec struct {
	conn io.ReadWriteCloser
	buf  *bufio.Writer
	dec  *gob.Decoder
	enc  *gob.Encoder
}

func (g GobCodec) Close() error {
	panic("implement me")
}

func (g GobCodec) ReadHeader(header *http.Header) error {
	panic("implement me")
}

func (g GobCodec) ReadBody(i interface{}) error {
	panic("implement me")
}

func (g GobCodec) Write(header *http.Header, i interface{}) error {
	panic("implement me")
}

type Codec interface {
	io.Closer
	ReadHeader(*http.Header) error
	ReadBody(interface{}) error
	Write(*http.Header, interface{}) error
}

var _ Codec = (*GobCodec)(nil)
