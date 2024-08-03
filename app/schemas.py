from pydantic import BaseModel

class SongBacklogBase(BaseModel):
    name: str
    
class SongBacklogCreate(SongBacklogBase):
    pass

class SongBacklog(SongBacklogBase):
    id: int
    band_id : int
    
    class Config:
        orm_mode=True    


class BandBase(BaseModel):
    title : str
    description : str | None = None

class BandCreate(BandBase):
    pass

class Band(BandBase):
    id : int
    owner_id  : int

    class Config:
        orm_mode = True

class UserBase(BaseModel):
    email: str
    name: str


class UserCreate(UserBase):
    pass 

class User(UserBase):
    id : int
    is_active : bool
    bands : list[Band] = []

    class Config:
        orm_model = True


        
        
        
