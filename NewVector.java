import java.util.Vector;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

class NewVector
{
    private double[] list;

    public NewVector()
    {
        list=new double[0];
    }

    public NewVector(int size, double D)
    {
        list = new double[size];
        for(int i = 0; i< size; i++)
        {
            list[i]=D;
        }
    }

    public NewVector(double[] D)
    {
        list = new double[D.length];
        System.arraycopy(D, 0, list, 0, D.length);
    }

    public NewVector(int[] I)
    {
        list = new double[I.length];
        for(int i = 0; i< I.length; i++)
        {
            list[i]=I[i];
        }
    }

    NewVector append(double[] doubleArray)
    {
        int i,j;
        double[] temp = new double[list.length+doubleArray.length];
        for(i = 0; i<list.length;i++)
        {
            temp[i]=list[i];
        }
        i=list.length;
        for(j=0;j<doubleArray.length;j++)
        {
            temp[i]=doubleArray[j];
            i+=1;
        }
        return new NewVector(temp);
    }

    NewVector append(int[] intArray)
    {
        int i,j;
        double[] temp = new double[intArray.length+list.length];
        for(i = 0; i<list.length;i++)
        {
            temp[i]=list[i];
        }
        i=list.length;
        for(j=0;j<intArray.length;j++)
        {
            temp[i]=intArray[j];
            i+=1;
        }
        return new NewVector(temp);
    }

    NewVector append(NewVector V)
    {
        int i,j;
        double[] temp = new double[V.list.length+list.length];
        for(i = 0; i<list.length;i++)
        {
            temp[i]=list[i];
        }
        i=list.length;
        for(j=0;j<V.list.length;j++)
        {
            temp[i]=V.list[j];
            i+=1;
        }
        return new NewVector(temp);
    }

    NewVector append (double D)
    {
        int i;
        NewVector temp = new NewVector(list.length+1,0);
        for(i=0;i<list.length;i++)
        {
            temp.list[i]=list[i];
        }
        temp.list[i]=D;
        return temp;
    }

    protected NewVector clone()
    {
        NewVector temp = new NewVector(list);
        return temp;
    }

    Boolean equal(NewVector V)
    {
        if(list.length==V.list.length)
        {
            for(int i=0;i<list.length;i++)
            {
                if(list[i]!=V.list[i])
                {
                    return false;
                }
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    int getLength()
    {
        return list.length;
    }

    double getValue(int i)
    {
        return list[i];
    }

    NewVector add(NewVector V)
    {
        if(V.list.length>=list.length)
        {
            for(int i =0;i<list.length;i++)
            {
                list[i]+=V.list[i];
            }
        }
        else
        {
            for(int i =0;i<V.list.length;i++)
            {
                list[i]+=V.list[i];
            }
        }
        return new NewVector(list);
    }

    NewVector add(double D)
    {
        for(int i = 0;i<list.length;i++)
        {
            list[i]+=D;
        }
        return new NewVector(list);
    }

    NewVector sub(NewVector V)
    {
        if(V.list.length>=list.length)
        {
            for(int i =0;i<list.length;i++)
            {
                list[i]-=V.list[i];
            }
        }
        else
        {
            for(int i =0;i<V.list.length;i++)
            {
                list[i]-=V.list[i];
            }
        }
        return new NewVector(list);
    }

    NewVector subV(int l,int r)
    {
        int i,j;
        j=0;
        NewVector temp = new NewVector(r-l+1,0);
        for(i=l;i<=r;i++)
        {
            temp.list[j]=list[i];
            j+=1;
        }
        return temp;
    }

    NewVector Mult(NewVector V)
    {
        if(V.list.length>=list.length)
        {
            for(int i =0;i<list.length;i++)
            {
                list[i]=list[i]*V.list[i];
            }
        }
        else
        {
            for(int i =0;i<V.list.length;i++)
            {
                list[i]=list[i]*V.list[i];
            }
        }
        return new NewVector(list);
    }

    NewVector Mult(double D)
    {
        for(int i=0;i<list.length;i++)
        {
            list[i]=list[i]*D;
        }
        return new NewVector(list);
    }

    Vector Normalize()
    {
        Vector temp = new Vector(list.length);
        for (double aList : list) {
            temp.add(aList);
        }
        return temp;
    }

    double EuclidianDistance(NewVector V)
    {
        int i;
        double temp;
        temp=0;
        if(V.list.length>=list.length)
        {
            for(i =0;i<list.length;i++)
            {
                temp+=pow(V.list[i]-list[i],2);
            }
            i+=1;
            for(; i<V.list.length; i++)
            {
                temp+=pow(V.list[i],2);
            }
        }
        else
        {
            for(i =0;i<V.list.length;i++)
            {
                for(i =0;i<V.list.length;i++)
                {
                    temp+=pow(V.list[i]-list[i],2);
                }
                i+=1;
                for(; i<list.length; i++)
                {
                    temp+=pow(list[i],2);
                }
            }
        }
        return sqrt(temp);
    }

    public void display()
    {
        for(int i=0;i<list.length;i++)
        {
            System.out.println(list[i]);
        }
    }
}
