from sqlalchemy import Boolean, Column, ForeignKey, Integer, String
from sqlalchemy.orm import relationship
from database import Base

class User(Base):
    __tablename__ = "users"
    id = Column(Integer,primary_key=True,index=True)
    name = Column(String(255),index=True)
    email = Column(String(255), unique=True, index=True)
    bands = relationship("Band",back_populates="owner")
    is_active = Column(Boolean,default=False)

class Band(Base):
    __tablename__ = "bands"
    id = Column(Integer, primary_key=True, index=True)
    title = Column(String(255), index=True)
    description = Column(String(255), index=True)
    owner_id = Column(Integer, ForeignKey("users.id"))
    owner = relationship("User",back_populates="bands")
    backlog = relationship("SongBacklog", back_populates="band")
    
class SongBacklog(Base):
    __tablename__ = "songBacklogs"
    id = Column(Integer, primary_key=True, index=True)
    name = Column(String(255),index=True)
    band_id = Column(Integer,ForeignKey("bands.id"))
    band = relationship("Band",back_populates="backlog") 
    



    
